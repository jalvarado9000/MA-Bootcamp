import React from "react";
import DashboardHeader from "./DashboardHeader";
import DashboardBalance from "./DashboardBalance";
import DashboardBody from "./DashboardBody";

const Dashboard = () => {
    return (
        <section className="dashboard-page">
            <DashboardHeader/>
            <DashboardBalance/>
            <DashboardBody/>
        </section>
    )
}

export default Dashboard;