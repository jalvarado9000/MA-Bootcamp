import React, {Component} from "react";

class TransactionDialog extends Component {

    constructor(props) {
        super(props);
        const todayDate = this.getLocalDateString();
    }

    getLocalDateString(date) {
        const today = new Date();
        const month = String(today.getMonth() + 1).padStart(2, "0");
        const day = String(today.getDate()).padStart(2, "0");
        return `${today.getFullYear()}-${month}-${day}`;
    }

    displayDialog = (show) => {
        return show ? "dialog show" : "dialog";
    }

    render() {
        return (
            <div id="transactionDialog" className={this.displayDialog(this.props.show)}>
                <div className="dialog-content">
                    <h2 className="text-center">Add transaction</h2>
                    <form id="transactionForm">
                        <label htmlFor="date">Date</label>
                        <input id="date" name="date" type="date"
                               required/>
                        <label htmlFor="object">Object</label>
                        <input id="object" name="object" type="text"
                               maxLength="50" required/>
                        <label htmlFor="amount">Amount (use negative value for debit)</label>
                        <input id="amount" name="amount" type="number"
                               step="any" required/>
                        <div id="transactionError" className="error" role="alert"/>
                        <div className="dialog-buttons">
                            <button type="button" className="button-alt"
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

TransactionDialog.defaultProps = {
    show: true
}

export default TransactionDialog;
