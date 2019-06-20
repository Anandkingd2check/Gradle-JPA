import React from 'react';
import './App.css';

class App extends React.Component {
    constructor() {
        super();
        this.state = { data: [] };
    }
    componentDidMount() {
        fetch(`http://localhost:8080/dogs/get-all-dogs`)
            //fetch(`https://api.coinmarketcap.com/v1/ticker/?limit=10`)
            .then(res => res.json())
            .then(json => this.setState({ data: json }));
    }
    render() {
        return (
            <div>
                <ul>
                    {this.state.data.map(dog => (
                        <li>
                            {dog.idDog}: {dog.name}
                        </li>
                    ))}
                </ul>
            </div>
        );
    }
}


export default App;