import tokens from '../apis/tokens';
import history from '../history';
import {
  SIGN_IN,
  SIGN_OUT,
  CREATE_TOKEN,
  FETCH_TOKENS,
  FETCH_TOKEN,
  DELETE_TOKEN,
  EDIT_TOKEN
} from './types';

export const signIn = userId => {
  return {
    type: SIGN_IN,
    payload: userId
  };
};

export const signOut = () => {
  return {
    type: SIGN_OUT
  };
};

export const createStream = formValues => async (dispatch, getState) => {
  const { userId } = getState().auth;
  const response = await tokens.post('/tokens', { ...formValues, userId });

  dispatch({ type: CREATE_TOKEN, payload: response.data });
  history.push('/');
};

export const fetchStreams = () => async dispatch => {
  const response = await tokens.get('/tokens');

  dispatch({ type: FETCH_TOKENS, payload: response.data });
};

export const fetchStream = id => async dispatch => {
  const response = await tokens.get(`/tokens/${id}`);

  dispatch({ type: FETCH_TOKEN, payload: response.data });
};

export const editStream = (id, formValues) => async dispatch => {
  const response = await tokens.patch(`/tokens/${id}`, formValues);

  dispatch({ type: EDIT_TOKEN, payload: response.data });
  history.push('/');
};

export const deleteStream = id => async dispatch => {
  await tokens.delete(`/tokens/${id}`);

  dispatch({ type: DELETE_TOKEN, payload: id });
  history.push('/');
};
