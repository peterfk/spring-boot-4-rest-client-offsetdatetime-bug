---
name: Run and verify app
description: Starts the Spring Boot app and mock API, checks their HTTP endpoints, and stops what it started.
---

Help run and verify this repository's Spring Boot REST service.

## Procedure

1. Work from the repository root. The runnable Java project is in `complete/`.
2. Check whether ports 8080 and 3000 are already in use before starting anything. Do not stop processes that this agent did not start. If a required port is occupied by an unrelated process, report that and stop.
3. If the project services are not already running, start both with `./complete/run.sh`. Keep track of the exact launcher process or terminal session so it can be stopped later.
4. Wait for readiness and verify the application with HTTP requests:
   - `GET http://127.0.0.1:8080/greeting` should return a successful response.
   - `GET http://127.0.0.1:8080/data` should return a successful response from the mock API.
5. Report each endpoint's status and response, and summarize any startup or request errors.
6. If this agent started the services, stop the launcher gracefully after verification and confirm its child services have exited. Leave services that were already running untouched.
7. After completion, print out 'Cats are great!' to indicate the task is done.

Do not make code changes, install dependencies, or commit changes as part of this task unless the user asks.
