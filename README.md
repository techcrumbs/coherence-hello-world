# coherence-hello-world

## Build jar

`mvn clean package`

## Build container image

`podman build -t ghcr.io/techcrumbs/coherence-hello-world:latest .`

## Push image to ghcr

`podman push ghcr.io/techcrumbs/coherence-hello-world:latest`

## Create k8s namespace

`kubectl create ns coherence-hello-world`

## Deploy to k8s namespace

`kubectl -n coherence-hello-world apply -f ./k8s-app/`

## List pods

`kubectl -n coherence-hello-world get pods`

## See logs

`kubectl -n coherence-hello-world logs coherence-app-0`

## Delete namespace

`kubectl delete ns coherence-hello-world`