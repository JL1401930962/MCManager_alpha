import axios from "axios";
// axios.defaults.baseURL =
//   "https://www.fastmock.site/mock/c2c6dbab7918b6a0d270dfc6c4d76d11/meiyi";
// axios.defaults.baseURL = "http://localhost:8088";

// // 请求拦截器
// axios.interceptors.request.use(config=>{
//   //如果存在jwt令牌，请求携带这个jwt令牌
//   if(window.localStorage.getItem('tokenStr')){
//       config.headers['Authorization']=window.localStorage.getItem('tokenStr');
//   }
//   return config;
// },error=>{
//   console.log(error);
// })

const request = (options) => {
  return axios.request(options).then((res) => {
    return Promise.resolve(res.data);
  });
};

const post = (url, params) => {
  const options = {
    url: url,
    method: "POST",
    timeout: 2000,
    data: params,
    headers: { "Content-Type": "application/json", "request-ajax": true },
  };
  return request(options);
};

const get = (url, params) => {
  const options = {
    url: url,
    method: "GET",
    timeout: 2000,
    params: params,
    headers: { "request-ajax": true },
  };
  return request(options);
};

const del = (url, params) => {
  const options = {
    url: url + "/" + params,
    method: "DELETE",
    // timeout: 2000,
    headers: { "request-ajax": true },
  };
  return request(options);
};

const del2 = (url) => {
  const options = {
    url: url,
    method: "DELETE",
    // timeout: 2000,
    headers: { "request-ajax": true },
  };
  return request(options);
};

const put = (url, params) => {
  const options = {
    url: url,
    method: "PUT",
    // timeout: 2000,
    params: params,
    headers: { "request-ajax": true },
  };
  return request(options);
};

export default {
  get,
  post,
  del,
  put,
  del2
};
