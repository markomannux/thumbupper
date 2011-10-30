
get "/", forward: "/WEB-INF/pages/index.gtpl"

get "/favicon.ico", redirect: "/images/gaelyk-small-favicon.png"

get "/secure", forward: "/WEB-INF/pages/secure.gtpl"

get "/free", forward: "/WEB-INF/pages/free.gtpl"
