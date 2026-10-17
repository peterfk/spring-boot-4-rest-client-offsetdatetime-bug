### Spring Boot 4 / Jackson 3 bug with `ADJUST_DATES_TO_CONTEXT_TIME_ZONE`

#### Manual

Run `json-server date.json`, then run the Spring Boot 4 app.

#### Automated

From the repository root, run `./complete/run.sh` (or run `./run.sh` from this
directory) to start the mock API and Spring Boot app together. This requires Java
17+ and Node.js/npm. Press Ctrl+C to stop both services.