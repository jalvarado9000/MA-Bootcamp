import { createStore } from 'redux';

const initialState = {
    showDialog: false,
    transactions: []
}

const reducer = (state = initialState, action) => {
    if (action.type === 'show') {
        return {
            ...state,
            showDialog: true
        };
    }

    if (action.type === 'hide') {
        return {
            ...state,
            showDialog: false
        };
    }

    if (action.type === 'addTransaction') {
        return {
            ...state,
            transactions: state.transactions.concat(action.payload)
        }
    }

    return state;
}

const store = createStore(
    reducer,
    // following line allows you to use the Redux DevTools in the browser
    window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
);

export default store;
