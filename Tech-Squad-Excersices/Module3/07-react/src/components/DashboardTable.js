import React from "react";
import DashboardTableRow from "./DashboardTableRow";

const DashboardTable = (props) => {

    const jsxTransactions = props.transactions.map(({date, object, amount}, index) => {
        return <DashboardTableRow key={index} date={date} object={object} amount={amount}/>
    });

    return (
        <table className="transactions-table">
            <thead>
            <tr>
                <th>Date</th>
                <th>Object</th>
                <th>Amount</th>
            </tr>
            </thead>
            <tbody id="transactions">{jsxTransactions}</tbody>
        </table>
    )
}

export default DashboardTable;