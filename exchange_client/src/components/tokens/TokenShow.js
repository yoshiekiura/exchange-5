import React from 'react';
import { connect } from 'react-redux';
import { fetchToken } from '../../actions';

class TokenShow extends React.Component {

  componentDidMount() {
    const {id} = this.props.match.params;
    this.props.fetchToken(id);
  }

  render() {
    if(!this.props.token){
      return (
        <div>Loading...</div>
      );
    }
    const {ticker, supply} = this.props.token;
    return (
      <div>
        <h1>{ticker}</h1>
        <h5>{supply}</h5>
      </div>
    );
  }
  
}

const mapStateToProps = (state, ownProps) => {
  return { token: state.tokens[ownProps.match.params.id] };
};

export default connect(mapStateToProps, {fetchToken})(TokenShow);
