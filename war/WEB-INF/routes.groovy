//get     "/", forward: "/WEB-INF/pages/index.gtpl"

get     "/", forward: "/WEB-INF/groovy/welcome.groovy"

get     "/favicon.ico", redirect: "/images/gaelyk-small-favicon.png"

get     "/goal/", forward: "/WEB-INF/groovy/goal/list.groovy"

//get     "/@ctx/@id", forward: "/WEB-INF/groovy/@ctx/get.groovy?id=@id"

get     "/goal/create", forward: "/WEB-INF/pages/goal/create.gtpl"

post    "/goal", forward: "/WEB-INF/groovy/goal/save.groovy"

get     "/secure", forward: "/WEB-INF/pages/secure.gtpl"

get     "/free", forward: "/WEB-INF/pages/free.gtpl"
