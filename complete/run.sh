#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR"

mock_pid=""
app_pid=""

cleanup() {
  trap - EXIT INT TERM
  if [[ -n "$app_pid" ]]; then
    kill "$app_pid" 2>/dev/null || true
    wait "$app_pid" 2>/dev/null || true
  fi
  if [[ -n "$mock_pid" ]]; then
    kill "$mock_pid" 2>/dev/null || true
    wait "$mock_pid" 2>/dev/null || true
  fi
}
trap cleanup EXIT INT TERM

npx --yes json-server@0.17.4 --watch date.json --host 127.0.0.1 --port 3000 &
mock_pid=$!

for _ in {1..30}; do
  if ! kill -0 "$mock_pid" 2>/dev/null; then
    echo "json-server exited before becoming ready." >&2
    exit 1
  fi
  if curl --silent --fail http://127.0.0.1:3000/data >/dev/null; then
    break
  fi
  sleep 1
done

if ! curl --silent --fail http://127.0.0.1:3000/data >/dev/null; then
  echo "json-server did not become ready on port 3000." >&2
  exit 1
fi

./mvnw spring-boot:run &
app_pid=$!
wait "$app_pid"
