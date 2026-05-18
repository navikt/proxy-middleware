# Proxy Middleware — Copilot Instructions

## Project Context

This is a Spring Boot 4 (Java 21) middleware/proxy running on Nais (GCP).
It sits between internal Nav services and external SaaS solutions (e.g. Ivalua),
forwarding and potentially transforming API calls.

- **Team:** oksty
- **Cluster:** dev-gcp / prod-gcp
- **Auth inbound:** Azure AD client_credentials (machine-to-machine)
- **Auth outbound:** OAuth2 client_credentials to external SaaS
- **Database:** None — structured logging to stdout only
- **Build:** Maven

## Commit Message Standard

Follow the Linus Torvalds style with conventional commit types.

### Format

```
type(scope): Short summary in imperative (max 72 chars)

Explain WHY, not what. The diff shows what. Wrap lines at 72
characters. Explain the problem, your reasoning, and any trade-offs
or alternatives you considered.

Refs: #<issue-number>
Signed-off-by: Your Name <you@example.com>
```

### Rules

- **Imperative mood** in header: "Add", "Fix", "Remove" — not "Added" or "Fixes"
- **Max 72 characters** in header line
- **No period** at end of header
- **Capital letter** after colon
- Body explains *why*, not *what* — the diff shows what changed
- Wrap body at 72 characters
- One logical change per commit

### Types

| Type | When to use |
|------|-------------|
| `feat` | New functionality or endpoint |
| `fix` | Bug fix |
| `refactor` | Code restructuring, no logic change |
| `docs` | Documentation only |
| `style` | Formatting, no logic change |
| `test` | Adding or updating tests |
| `chore` | Dependencies, configuration, maintenance |

### Scopes

Use the integration or module being changed:

```
feat(ivalua): ...
fix(security): ...
chore(deps): ...
refactor(config): ...
```

### Trailers

```
Refs: #247
Closes: #312
Signed-off-by: Your Name <you@example.com>
```

**No `Co-authored-by` trailers.** This team does not use them.

### Examples

```
feat(ivalua): add paginated GET endpoint for contracts

Consumers need to list active contracts per supplier. Implemented
as a paginated endpoint proxying through to Ivalua's contract API.

Considered caching but current volume does not justify complexity.

Signed-off-by: Borse Schumacher Haraldsen <borse.schumacher.haraldsen@nav.no>
```

```
fix(security): reject tokens without required audience claim

Tokens missing the expected audience were accepted due to a
misconfigured issuer-uri. This allowed any Azure AD token to
access the proxy regardless of intended audience.

Refs: #42
Signed-off-by: Borse Schumacher Haraldsen <borse.schumacher.haraldsen@nav.no>
```

### What to Avoid

| Bad | Why |
|-----|-----|
| `fix bug` | Says nothing — which bug, where, why? |
| `WIP` | Clean up before merging |
| Mixing bugfix and refactoring | Makes revert and bisect difficult |

## Code Style

- Java 21, use records where appropriate
- No Lombok — use IDE generation or records
- Prefer Spring RestClient over WebClient for synchronous calls
- No PII (fnr, names, addresses) in logs — ever
- Structured logging with slf4j + logstash-encoder

## Nais / Platform

- Health endpoints: `/internal/isalive`, `/internal/isready`
- Metrics: `/internal/prometheus` (actuator)
- No CPU limits — only requests
- accessPolicy: deny-all by default, explicit rules only
