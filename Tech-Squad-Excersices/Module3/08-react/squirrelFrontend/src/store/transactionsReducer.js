
const initialState = [];

const transactionsReducer = (state = initialState, action) => {

    switch (action.type) {
        case 'addTransaction': {
            return state.concat(action.payload)
        }
        case 'initialize': {
            return action.payload
        }
        default: {
            return state;
        }
    }
}

export default transactionsReducer;
