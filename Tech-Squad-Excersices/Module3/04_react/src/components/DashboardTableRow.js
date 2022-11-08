import React from "react";

const DashboardTableRow = (props) => {
    return (
        <tr>
            <td>{props.date}</td>
            <td>{props.object}</td>
            <td>{props.amount.toFixed(2)}</td>
        </tr>
    )
}

export default DashboardTableRow;
