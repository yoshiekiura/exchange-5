import React from 'react';
import { Field, reduxForm } from 'redux-form';


class TokenForm extends React.Component {

    renderError({error, touched}) {
        if(touched && error) {
            return (
                <div className="ui error message">
                    <div className="header">
                        {error}
                    </div>
                </div>
            );
        }
    }

    renderInput = ({input, label, meta}) => {
        const className = `field ${meta.error && meta.touched ? 'error' : ''}`;

        return (
            <div className={className}>
                <label>{label}</label>
                <input {...input} />
                <div>{this.renderError(meta)}</div>
            </div>
        );
    }

    onSubmit = (formValues) => {
        this.props.onSubmit(formValues);
    }

    render () {
        return (
            <form onSubmit={this.props.handleSubmit(this.onSubmit)} className="ui form error">
                <Field name="ticker" component={this.renderInput} label="Enter Ticker" />
                <Field name="supply" component={this.renderInput} label="Enter the Supply" />
                <button className="ui button primary">Submit</button>
            </form>
        );
    }
}

const validate = (formValues) => {
    const errors = {};

    if(!formValues.ticker) {
        errors.ticker = 'You must enter a ticker';
    }
    if(!formValues.supply) {
        errors.supply = 'You must enter a supply';
    }

    return errors;
};


export default reduxForm({
    form: 'tokenForm',
    validate
})(TokenForm);
