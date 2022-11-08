import {combineReducers, createStore} from 'redux';
import dialogReducer from "./dialogReducer";
import transactionsReducer from "./transactionsReducer";

const reducer = combineReducers({
    transactionDialog: dialogReducer,
    transactions: transactionsReducer
});

const store = createStore(
    reducer,
    // following line allows you to use the Redux DevTools in the browser
    window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
);

export default store;
