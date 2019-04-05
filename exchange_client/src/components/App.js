import React from 'react';
import { Router, Route, Switch } from 'react-router-dom';
import StreamCreate from './streams/StreamCreate';
import StreamEdit from './streams/StreamEdit';
import StreamDelete from './streams/StreamDelete';
import StreamList from './streams/StreamList';
import StreamShow from './streams/StreamShow';

import TokenCreate from './tokens/TokenCreate';
import TokenEdit from './tokens/TokenEdit';
import TokenDelete from './tokens/TokenDelete';
import TokenList from './tokens/TokenList';
import TokenShow from './tokens/TokenShow';

import Header from './Header';
import history from '../history';

const App = () => {
  return (
    <div className="ui container">
      <Router history={history}>
        <div>
          <Header />
          <Switch>
            <Route path="/" exact component={StreamList} />
            <Route path="/streams/new" exact component={StreamCreate} />
            <Route path="/streams/edit/:id" exact component={StreamEdit} />
            <Route path="/streams/delete/:id" exact component={StreamDelete} />
            <Route path="/streams/:id" exact component={StreamShow} />
          </Switch>
          <Switch>
            <Route path="/" exact component={TokenList} />
            <Route path="/tokens/new" exact component={TokenCreate} />
            <Route path="/tokens/edit/:id" exact component={TokenEdit} />
            <Route path="/tokens/delete/:id" exact component={TokenDelete} />
            <Route path="/tokens/:id" exact component={TokenShow} />
          </Switch>
        </div>
      </Router>
    </div>
  );
};

export default App;
