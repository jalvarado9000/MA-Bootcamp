import React, {Component} from "react";
import TransactionDialog from "./TransactionDialog";
import {connect} from "react-redux";

class DashboardTitle extends Component {

    showModal = () => {
        this.props.openDialog();
    }

    hideModal = () => {
        this.props.closeDialog();
    }

    render() {
        return (
            <div className="transactions-title">
                <h2 id="description">Test account</h2>
                <button onClick={this.showModal}>Add transaction</button>
                <TransactionDialog show={this.props.isDialogOpen} handleClose={this.hideModal}/>
            </div>
        )
    }
}

const mapStateToProps = (state) => {
    return {
        isDialogOpen: state.showDialog
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        openDialog: () => dispatch({type: 'show'}),
        closeDialog: () => dispatch({type: 'hide'})
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(DashboardTitle);
