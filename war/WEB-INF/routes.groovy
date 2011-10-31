
get     "/", forward: "/WEB-INF/pages/index.gtpl"

get     "/favicon.ico", redirect: "/images/gaelyk-small-favicon.png"

get     "/@ctx/create", forward: "/WEB-INF/pages/@ctx/create.gtpl"

post    "/@ctx/save", forward: "/WEB-INF/groovy/@ctx/save.groovy"

get     "/secure", forward: "/WEB-INF/pages/secure.gtpl"

get     "/free", forward: "/WEB-INF/pages/free.gtpl"
