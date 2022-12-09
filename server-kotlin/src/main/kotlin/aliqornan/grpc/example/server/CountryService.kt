package aliqornan.grpc.example.server

import aliqornan.grpc.example.protocontract.CountryServiceGrpcKt
import aliqornan.grpc.example.protocontract.LookupRequest
import aliqornan.grpc.example.protocontract.country
import aliqornan.grpc.example.protocontract.lookupReply

class CountryService : CountryServiceGrpcKt.CountryServiceCoroutineImplBase() {

    override suspend fun lookup(request: LookupRequest) = lookupReply {
        data = findCountryByCode(request.code)
        success = true
    }

    private fun findCountryByCode(countryCode: String) = country {
        code = "ID"
        officialName = "Republik Indonesia"
        numberOfPopulation = 2000000
        tourismRating = 4.5f
    }

}
