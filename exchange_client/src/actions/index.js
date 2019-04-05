import streams from '../apis/streams';
import tokens from '../apis/tokens';
import history from '../history';
import {
  SIGN_IN,
  SIGN_OUT,
  CREATE_STREAM,
  FETCH_STREAMS,
  FETCH_STREAM,
  DELETE_STREAM,
  EDIT_STREAM,
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
  const response = await streams.post('/streams', { ...formValues, userId });

  dispatch({ type: CREATE_STREAM, payload: response.data });
  history.push('/');
};

export const fetchStreams = () => async dispatch => {
  const response = await streams.get('/streams');

  dispatch({ type: FETCH_STREAMS, payload: response.data });
};

export const fetchStream = id => async dispatch => {
  const response = await streams.get(`/streams/${id}`);

  dispatch({ type: FETCH_STREAM, payload: response.data });
};

export const editStream = (id, formValues) => async dispatch => {
  const response = await streams.patch(`/streams/${id}`, formValues);

  dispatch({ type: EDIT_STREAM, payload: response.data });
  history.push('/');
};

export const deleteStream = id => async dispatch => {
  await streams.delete(`/streams/${id}`);

  dispatch({ type: DELETE_STREAM, payload: id });
  history.push('/');
};



export const createToken = formValues => async (dispatch, getState) => {
  const { userId } = getState().auth;
  const response = await tokens.post('/tokens', { ...formValues, userId });

  dispatch({ type: CREATE_TOKEN, payload: response.data });
  history.push('/');
};

export const fetchTokens = () => async dispatch => {
  const response = await tokens.get('/tokens');

  dispatch({ type: FETCH_TOKENS, payload: response.data });
};

export const fetchToken = id => async dispatch => {
  const response = await tokens.get(`/tokens/${id}`);

  dispatch({ type: FETCH_TOKEN, payload: response.data });
};

export const editToken = (id, formValues) => async dispatch => {
  const response = await tokens.patch(`/tokens/${id}`, formValues);

  dispatch({ type: EDIT_TOKEN, payload: response.data });
  history.push('/');
};

export const deleteToken = id => async dispatch => {
  await tokens.delete(`/tokens/${id}`);

  dispatch({ type: DELETE_TOKEN, payload: id });
  history.push('/');
};
