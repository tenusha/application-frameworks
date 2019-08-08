import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';

import { Provider } from 'react-redux'
import { combineReducers, createStore } from 'redux'

import userReducer from './reducers/userReducer'
import ProductsReducer from './reducers/ProductsReducer'

const allReducers = combineReducers({
    products: ProductsReducer,
    user: userReducer
})

const store = createStore(
    allReducers,
    {
        products: [{ name: 'p1', price: 36217 }],
        user: { name: 'bob' }
    },
    window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
)

ReactDOM.render(<Provider store={store}><App /></Provider>, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
