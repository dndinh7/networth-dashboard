# networth-dashboard
dashboard for seeing your net worth

# start program
use docker compose up to start up the containers

# remove containers and volume
docker compose down [-v]

# to login
You will need to call "/auth/register" and then "/auth/login" to get a bearer token.
Then to call the next APIs, use the bearer token from that login response.