import axios from 'axios';
//const keys = require('../keys');

// export default axios.create({
//   baseURL: `http://${keys.apiAddress}:${keys.apiPort}/api`
// });

export default axios.create({
  baseURL: 'http://172.17.0.1:9090/api'
});

