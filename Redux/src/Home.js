import React, { Component } from 'react';
import { connect } from 'react-redux'
import { updateUser } from './actions/user-actions';

class Home extends Component {

	render() {
		return (
			<div className="App" onClick={() => this.props.onUpdate({ name: 'john' })}>
				<p>{this.props.user.name}</p>
				<p>{this.props.custom}</p>
				<p>{this.props.added}</p>
			</div>
		);
	}
}

const mapStateToProps = (state, props) => {
	console.log(props)
	return {
		products: state.products,
		user: state.user,
		custom: props.randomProp,
		added: `${state.user.name} ${props.randomProp}`
	}
}

const mapActionsToProps = {
	onUpdate: updateUser
}

export default connect(mapStateToProps, mapActionsToProps)(Home)

// const mapActionsToProps = (dispatch, props) => {
// 	return bindActionCreators({
// 		onUpdate: updateUser
// 	}, dispatch)
// }

// const mergeProps = (propsFrompState, propsFromDispatch, ownProps) => {
// 	return {...propsFrompState, ...propsFromDispatch, ...ownProps}
// }

// export default connect(mapStateToProps, mapActionsToProps, mergeProps)(Home)