import React, {Component} from "react";
import TransactionDialog from "./TransactionDialog";

class DashboardTitle extends Component {

    render() {
        return (
            <div className="transactions-title">
                <h2 id="description">Test account</h2>
                <button>Add transaction</button>
                <TransactionDialog/>
            </div>
        )
    }
}

export default DashboardTitle;