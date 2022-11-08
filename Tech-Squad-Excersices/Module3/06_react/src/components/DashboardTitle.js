import React, {Component} from "react";
import TransactionDialog from "./TransactionDialog";

class DashboardTitle extends Component {

    constructor(props) {
        super(props);
        this.state = {
            show: false
        }
    }

    showModal = () => {
        this.setState({show: true})
    }

    hideModal = () => {
        this.setState({show: false})
    }

    render() {
        return (
            <div className="transactions-title">
                <h2 id="description">Test account</h2>
                <button onClick={this.showModal}>Add transaction</button>
                <TransactionDialog show={this.state.show} handleClose={this.hideModal}/>
            </div>
        )
    }
}

export default DashboardTitle;