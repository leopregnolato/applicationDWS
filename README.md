# DWS BRAZIL Admission Test API

This API was designed to fulfill the admission test requirements for the Back-End Developer position at DWS BRAZIL.

## API Documentation (Swagger UI)

The application includes Swagger (OpenAPI) documentation. You can access the interactive documentation to explore all endpoints, request models, and response structures at the following URL:

http://localhost:8080/swagger-ui/index.html

![application/swagger.png](https://github.com/leopregnolato/applicationDWS/blob/develop/swagger.png))


## Example Usage

### Fetching Musical Groups (Paged)

To retrieve a list of musical groups with default pagination, use the following `curl` command:

```bash
curl --location 'http://localhost:8080/api/v1/musical_groups'
