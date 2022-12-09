# grpc-example

An example of gRPC written in many languages

## Modules

- proto-contract: Contract of grpc-example project written in protobuf
- client-kotlin: An example of client stub implementation of gRPC in kotlin
- server-kotlin: An example of server stub implementation of gRPC in kotlin

## How to generate proto contract

### Java

Prerequisite:

- JDK 11 or higher

Open terminal and execute command below:

```
./gradlew clean :proto-contract:build
```

It will be generated on directory `proto-contract/build/generated/source/proto/main`

## Kotlin

Prerequisite:

- JDK 11 or higher

Open terminal and execute command below:

```
./gradlew clean :proto-contract:build
```

It will be generated on directory `proto-contract/build/generated/source/proto/main`

### Ruby

Prerequisite:

- Ruby `v2.7.*` or higher

Setup dependencies by executing these commands below in terminal:

```
gem install grpc
gem install grpc-tools
```

Execute example command below in terminal:

```
grpc_tools_ruby_protoc -I proto-contract/src/main/proto/aliqornan/grpc/example/protocontract --ruby_out=generated/proto/ruby --grpc_out=generated/proto/ruby proto-contract/src/main/proto/aliqornan/grpc/example/protocontract/country.proto
```

It will be generated on directory `generated/proto/ruby`

### Golang

Prerequisite:

- Go `v1.19.*` or higher

Setup dependencies by executing these commands below in terminal:

```
go install google.golang.org/protobuf/cmd/protoc-gen-go@v1.28
go install google.golang.org/grpc/cmd/protoc-gen-go-grpc@v1.2
export PATH="$PATH:$(go env GOPATH)/bin"
```

Execute example command below in terminal:

```
protoc --go_out=generated/proto/go --go_opt=paths=source_relative --go-grpc_out=generated/proto/go --go-grpc_opt=paths=source_relative proto-contract/src/main/proto/aliqornan/grpc/example/protocontract/country.proto
```

It will be generated on directory `generated/proto/go`
