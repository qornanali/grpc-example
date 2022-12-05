package aliqornan.grpc.example.server

import aliqornan.grpc.example.protocontract.Country
import aliqornan.grpc.example.protocontract.CountryServiceGrpcKt
import aliqornan.grpc.example.protocontract.LookupReply
import aliqornan.grpc.example.protocontract.LookupRequest

class CountryService : CountryServiceGrpcKt.CountryServiceCoroutineImplBase() {

    override suspend fun lookup(request: LookupRequest): LookupReply = LookupReply.newBuilder()
        .setData(findCountryByCode(request.code))
        .setSuccess(true)
        .build()

    private fun findCountryByCode(code: String): Country? = Country.newBuilder()
        .setCode("ID")
        .setOfficialName("Republik Indonesia")
        .build()

}
