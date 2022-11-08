import React from "react";
import {useSelector} from "react-redux";

const DashboardBalance = () => {

    // grab the transactions from the Redux state store
    const transactions = useSelector(state => state.transactions);
    
    const totalBalance = transactions.reduce((total, current) => total + current.amount, 0);

    return (
        <div className="balance">
            <div>Balance</div>
            <span id="balance">{totalBalance.toFixed(2)}</span>
            <span id="currency">$</span>
        </div>
    )
}

export default DashboardBalance;