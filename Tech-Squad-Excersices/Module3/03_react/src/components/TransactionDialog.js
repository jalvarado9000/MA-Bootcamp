import React, {Component} from "react";

class TransactionDialog extends Component {

    displayDialog(show) {
        return show ? "show" : "";
    }

    render() {
        return (
            /* adding a class of show will open/display the dialog */
            <div id="transactionDialog" className="dialog">
                <div className="dialog-content">
                    <h2 className="text-center">Add transaction</h2>
                    <form id="transactionForm">
                        <label htmlFor="date">Date</label>
                        <input id="date" name="date" type="date" required/>
                        <label htmlFor="object">Object</label>
                        <input id="object" name="object" type="text" maxLength="50" required/>
                        <label htmlFor="amount">Amount (use negative value for debit)</label>
                        <input id="amount" name="amount" type="number" step="any" required/>
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

export default TransactionDialog;
