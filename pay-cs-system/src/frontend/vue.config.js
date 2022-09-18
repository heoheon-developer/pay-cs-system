module.exports={

  devServer: {
    proxy: {
      '/': {
        "target": 'http://localhost:8080',
        "pathRewrite": { '^/': '' },
        "changeOrigin": true,
        "logLevel":"debug",
        "secure": false
      }
    }
  }

}
