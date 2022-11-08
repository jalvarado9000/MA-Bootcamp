import React, {Component} from "react";
import {connect} from "react-redux";

class TransactionDialog extends Component {

    constructor(props) {
        super(props);
        const todayDate = this.getLocalDateString();
        this.initialState = ({
            date: todayDate,
            object: "",
            amount: 0
        });
        this.state = this.initialState;
    }

    getLocalDateString() {
        const today = new Date();
        const month = String(today.getMonth() + 1).padStart(2, "0");
        const day = String(today.getDate()).padStart(2, "0");
        return `${today.getFullYear()}-${month}-${day}`;
    }

    dialogClasses = (show) => {
        return show ? "dialog show" : "dialog";
    }

    amountOnChangeHandle = (event) => {
        this.setState({amount: event.target.value});
    }

    dateOnChangeHandle = (event) => {
        this.setState({date: event.target.value});
    }

    objectOnChangeHandle = (event) => {
        this.setState({object: event.target.value});
    }

    oKButtonOnClickHandle = (event) => {
        // prevent webpage refresh
        event.preventDefault();

        // gather data from the form
        const newTransaction = {
            date: this.state.date,
            object: this.state.object,
            amount: Number.parseFloat(this.state.amount)
        }

        // trigger an update/send a new transaction to the Redux state
        this.props.dispatchTransaction(newTransaction);

        // Reset the state when clicking on OK
        this.setState(this.initialState);

        // The form should disappear when clicking on OK
        this.props.handleClose();
    }

    render() {
        // console.log("TransactionDialog props:")
        // console.log(this.props);
        return (
            <div id="transactionDialog" className={this.dialogClasses(this.props.show)}>
                <div className="dialog-content">
                    <h2 className="text-center">Add transaction</h2>
                    <form id="transactionForm" onSubmit={this.oKButtonOnClickHandle}>
                        <label htmlFor="date">Date</label>
                        <input id="date" name="date" type="date" value={this.state.date}
                               onChange={this.dateOnChangeHandle} required/>
                        <label htmlFor="object">Object</label>
                        <input id="object" name="object" type="text" value={this.state.object}
                               onChange={this.objectOnChangeHandle} maxLength="50" required/>
                        <label htmlFor="amount">Amount (use negative value for debit)</label>
                        <input id="amount" name="amount" type="number" value={this.state.amount}
                               onChange={this.amountOnChangeHandle} step="any" required/>
                        <div id="transactionError" className="error" role="alert"/>
                        <div className="dialog-buttons">
                            <button type="button" className="button-alt"
                                    onClick={this.props.handleClose}
                                    formNoValidate>Cancel
                            </button>
                            <button>OK</button>
                        </div>
                    </form>
                </div>
            </div>
        )
    }
}

// we are creating a function that will be available in the
// TransactionDialog class (above) to update the Redux store with a new transaction
const mapDispatchToProps = (dispatch) => {
    return {
        dispatchTransaction: (newTransaction) => dispatch({type: 'addTransaction', payload: newTransaction})
    }
}

export default connect(null, mapDispatchToProps)(TransactionDialog);
