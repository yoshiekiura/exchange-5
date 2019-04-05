import React from 'react';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';
import Modal from '../Modal';
import history from '../../history';
import { fetchToken, deleteToken } from '../../actions';

class TokenDelete extends React.Component {
  componentDidMount() {
    this.props.fetchToken(this.props.match.params.id);
  }

  renderActions() {
    const { id } = this.props.match.params;

    return (
      <React.Fragment>
        <button
          onClick={() => this.props.deleteToken(id)}
          className="ui button negative"
        >
          Delete
        </button>
        <Link to="/" className="ui button">
          Cancel
        </Link>
      </React.Fragment>
    );
  }

  renderContent() {
    if (!this.props.token) {
      return 'Are you sure you want to delete this token?';
    }

    return `Are you sure you want to delete the token with ticker: ${this.props.token.ticker}`;
  }

  render() {
    return (
      <Modal
        title="Delete Token"
        content={this.renderContent()}
        actions={this.renderActions()}
        onDismiss={() => history.push('/')}
      />
    );
  }
}

const mapStateToProps = (state, ownProps) => {
  return { token: state.tokens[ownProps.match.params.id] };
};

export default connect(
  mapStateToProps,
  { fetchToken, deleteToken }
)(TokenDelete);
