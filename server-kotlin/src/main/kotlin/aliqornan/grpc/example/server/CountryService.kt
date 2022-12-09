package aliqornan.grpc.example.server

import aliqornan.grpc.example.protocontract.*

class CountryService : CountryServiceGrpcKt.CountryServiceCoroutineImplBase() {

    override suspend fun lookup(request: LookupRequest): LookupReply = lookupReply {
        data = findCountryByCode(request.code)
        success = true
    }

    private fun findCountryByCode(countryCode: String): Country = country {
        code = "ID"
        officialName = "Republik Indonesia"
        numberOfPopulation = 2000000
        tourismRating = 4.5f
    }

}
