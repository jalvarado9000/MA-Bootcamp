import React from "react";
import logo from "../logo.svg"

const DashboardHeader = () => {
    return (
        <header className="dashboard-header">
            <img className="dashboard-logo" src={logo} alt="Squirrel Banking Logo"/>
            <h1 className="dashboard-title hide-xs">Squirrel Banking</h1>
            <button>Logout</button>
        </header>
    )
}

export default DashboardHeader;
