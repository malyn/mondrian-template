(ns leiningen.new.mondrian
  (:use [leiningen.new.templates :only [renderer name-to-path ->files]]))

(def render (renderer "mondrian"))

(defn mondrian
  "lein-newnew template for mondrian projects"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (->files data
             [".gitignore" (render "gitignore" data)]
             ["externs/jquery-1.9.js" (render "jquery-1.9.js")]
             ["externs/jquery-ui.js" (render "jquery-ui.js")]
             ["project.clj" (render "project.clj" data)]
             ["resources/public/index.html" (render "index.html" data)]
             ["src/clj/{{sanitized}}/server.clj" (render "server.clj" data)]
             ["src/cljs/{{sanitized}}/{{name}}.cljs" (render "artwork.cljs" data)]
             ["src/cljs-repl/{{sanitized}}/repl.cljs" (render "repl.cljs" data)])))
