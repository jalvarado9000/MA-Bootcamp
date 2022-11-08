import React, {Component} from "react";
import DashboardTitle from "./DashboardTitle";
import DashboardTable from "./DashboardTable";
import {getTransactions} from "../data";
import {connect} from "react-redux";

class DashboardBody extends Component {

    componentDidMount() {
        this.props.initialize(getTransactions());
    }

    render() {
        return (
            <div className="dashboard-content">
                <DashboardTitle/>
                <DashboardTable transactions={this.props.transactions}/>
            </div>
        )
    }
}

const mapStateToProps = (state) => {
    return {
        transactions: state.transactions
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        initialize: (transactions) => dispatch({type: 'initialize', payload: transactions}),
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(DashboardBody);
