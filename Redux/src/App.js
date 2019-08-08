import React, { Component } from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import Home from './Home'
import Test from './Test'

class App extends Component {

	render() {
		return (
			<>
				<Router>
					<Switch>
						<Route exact path='/' component={() => <Home randomProp="whatever" />} />
						<Route exact path='/test' component={Test} />
					</Switch>
				</Router>
				<div className="App">
					<input type="button" value="Show Popup" onClick={this.handleClick} />
				</div>
			</>
		);
	}
}

export default App


// handleClick = () => {
// 	fetch("http://localhost:8080/popup", {
// 		method: 'GET'
// 	}).then(res => {
// 		return res.json()
// 	}).then(data => {
// 		console.log(data)
// 		window.location.href = data.url
// 	}).catch(function (error) {
// 		console.log('Request failed', error)
// 	})
// }