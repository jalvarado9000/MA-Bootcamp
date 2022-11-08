
const initialState = {
    shouldDisplay: false
}

const dialogReducer = (state = initialState, action) => {
    switch (action.type) {
        case 'show': {
            return {
                shouldDisplay: true
            }
        }
        case 'hide': {
            return {
                shouldDisplay: false
            }
        }
        default:
            return state;
    }
}

export default dialogReducer;
