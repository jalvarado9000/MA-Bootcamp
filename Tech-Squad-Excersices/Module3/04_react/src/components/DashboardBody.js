import React from "react";
import DashboardTitle from "./DashboardTitle";
import DashboardTable from "./DashboardTable";
import {getTransactions} from "../data";

const DashboardBody = () => {
    return (
        <div className="dashboard-content">
            <DashboardTitle/>
            <DashboardTable transactions={getTransactions()}/>
        </div>
    )
}

export default DashboardBody;