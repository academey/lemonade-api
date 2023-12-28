package com.kakao.bank.blog.search.infra.search.kakao

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.kakao.bank.blog.search.domain.blog.Blog
import com.kakao.bank.blog.search.domain.blog.BlogVendorType

// {"documents":[{"blogname":"밍경송의 E.B","contents":"확인 \u0026#34; Are we building \u0026#39;product right\u0026#39;? \u0026#34; -\u0026gt; 제대로된 제품인가? 3) Review : 작업제품검사 .. -\u0026gt; 체크리스트로 진행 가능 / 단계마다 검토 (static \u003cb\u003etest\u003c/b\u003e) 4) Testing : 요구사항을 만족하는지 확인 + 이상 감지. 실행시킨 결과 == 기대한 결과 ? (dynamic \u003cb\u003etest\u003c/b\u003e) -- 1) 과 2)의 차이 알기 / 3) 과 4)는 모두 결함...","datetime":"2023-12-10T17:32:19.000+09:00","thumbnail":"https://search1.kakaocdn.net/argon/130x130_85_c/1nFWJ8pM5MC","title":"\u0026lt;9\u0026gt; Verification, Validation, and \u003cb\u003eTest\u003c/b\u003e","url":"https://mgyxxmi0219.tistory.com/72"},{"blogname":"제인로그","contents":"TDD(\u003cb\u003eTest\u003c/b\u003e-Driven Development) 테스트 주도 개발(\u003cb\u003eTest\u003c/b\u003e-driven development TDD)이란, 반복 테스트를 이용한 소프트웨어 방법론으로, 매우 짧은 개발 사이클을 반복하는 소프트웨어 개발 프로세스 중 하나입니다. TDD 개발주기 Red: 실패하는 테스트 코드 작성 Green: 실패한 테스트를 통과하기 위한 최소한의 코드 변경...","datetime":"2023-12-14T13:53:49.000+09:00","thumbnail":"https://search3.kakaocdn.net/argon/130x130_85_c/D3jPkbWWoXk","title":"[iOS] TDD와 Unit \u003cb\u003eTest\u003c/b\u003e","url":"https://janechoi.tistory.com/74"},{"blogname":"직업으로서의 개발자","contents":"\u003cb\u003etest\u003c/b\u003e Purpose of Integration \u003cb\u003eTest\u003c/b\u003e 여러 컴포넌트 간 상호작용이 정상적으로 수행되는지 DAO가 올바르게 연결돼 있어서 원하는 데이터를 저장, 읽을 수 있는지? \u003cb\u003eTest\u003c/b\u003e Environment Setup 멱등성(idempotent) 유지 연산을 여러 번 적용하더라도 결과가 달라지지 않는 성질 멱등성이 깨지기 쉬운 구간 → 외부 모듈 → DB...","datetime":"2023-12-02T20:10:24.000+09:00","thumbnail":"https://search4.kakaocdn.net/argon/130x130_85_c/DPkUPOQyUDH","title":"Spring batch integration \u003cb\u003etest\u003c/b\u003e (feat.Elasticsearch)","url":"https://developer-as-job.tistory.com/11"},{"blogname":"디발자 지망일기","contents":"[ \u003cb\u003eTest\u003c/b\u003e Flight ] [ \u003cb\u003eTest\u003c/b\u003e Flight란 ? ] TestFlight는 개발자가 테스트 목적으로 선택된 사용자 그룹에게 iOS 앱의 시험판 버전을 배포할 수 있도록 Apple에서 제공하는 플랫폼이다. 이 프로세스를 흔히 베타 테스트라고 한다 . 1 . 베타 테스트: TestFlight는 iOS 앱 베타 테스트에 사용된다. 베타 테스트는 아직 공개적...","datetime":"2023-11-15T14:55:25.000+09:00","thumbnail":"https://search3.kakaocdn.net/argon/130x130_85_c/IZHKlB7okMf","title":"[ ios 개발 ] 04 . \u003cb\u003eTest\u003c/b\u003e Flight 프로젝트 빌드하기","url":"https://yeoyeoyeo.tistory.com/257"},{"blogname":"대장부의 삶","contents":"제품을 직접 힘을가해 파손시킬 수 없기 때문에 제품과 시험편이라고 하는 같은 재료로 만들어진 시험용 소편(小片)을 이용합니다. 시험편을 \u003cb\u003eTest\u003c/b\u003e specimen, Specimen,\u003cb\u003eTest\u003c/b\u003e Piece 등 영어로 다양하게 쓰이고 있고, 일본어로 試驗片(しけんへん)이라고 합니다. 시험편의 모양은 재질에 따라 1~12호 12가지 종류는 각각...","datetime":"2023-11-28T15:14:53.000+09:00","thumbnail":"https://search2.kakaocdn.net/argon/130x130_85_c/3TOgJItt3wQ","title":"인장 시험 (Tensile \u003cb\u003eTest\u003c/b\u003e·引張試験)","url":"https://hihoya.tistory.com/23"},{"blogname":"Davinci Codex","contents":"개요 - 사후검정(Post Hoc) 말고 하는 방법 - ex) 수학 모의고사를 고3, A대학 수학과, 화학과, 영문학과, 역사학과 신입생 대상 실시 - 일반적인 F-\u003cb\u003etest\u003c/b\u003e $$ H_0 : \\mu_{고3} = \\mu_{수학과} = \\mu_{화학과} =\\mu_{영문학과} =\\mu_{역사학과} $$ $$ H_1 : 5개의\\ 그룹의\\ 수학점수\\ 중\\ 적어도\\ 한\\ 그룹\\ 수학점수는...","datetime":"2023-12-06T17:55:34.000+09:00","thumbnail":"https://search3.kakaocdn.net/argon/130x130_85_c/IxX0qjqWVR4","title":"통계학 (5) - Contrasts \u003cb\u003eTest\u003c/b\u003e (대비검정)","url":"https://klee30810.tistory.com/67"},{"blogname":"Nowon의 블로그","contents":"이번엔 replicasets 에 대한 Practice이다. default 네임스페이스에 파드가 얼마나 있나요? k get po 명령어를 이용해서 체크해봄 하나도 없다 ReplicaSets 가 얼마나 있나요? 동일하게 k get rs 명령어를 입력해서 확인함 kubectl get replicaset # 이렇게 확인해도 되지만 kubectl==k replicaset==rs 로 축약할 수...","datetime":"2023-11-29T22:00:13.000+09:00","thumbnail":"https://search3.kakaocdn.net/argon/130x130_85_c/AzTf3si85mv","title":"[CKA] Practice \u003cb\u003eTest\u003c/b\u003e - replicasets","url":"https://nowon9159.tistory.com/193"},{"blogname":"남웅니","contents":"we building the right product? ( 제대로 된 부품을 만들었느냐) 결함을 찾아내기 위한 단계 -\u0026gt; Review : 각 단계의 산출물을 가지고 검토하는 것 : static \u003cb\u003etest\u003c/b\u003e (코드 없이 하는 정적 테스트) -\u0026gt; Testing : 실행시킨 결과를 바탕으로 우리가 원하는 결과가 제대로 나오는지 동작을 확인 : dynamic \u003cb\u003etest\u003c/b\u003e (실행시키며...","datetime":"2023-12-10T18:05:45.000+09:00","thumbnail":"https://search2.kakaocdn.net/argon/130x130_85_c/D8IwwNB48NN","title":"Verification, Validation, and \u003cb\u003eTest\u003c/b\u003e","url":"https://marc11.tistory.com/104"},{"blogname":"Tech Trail","contents":"Flutter로 개발을 진행하면서 Widget \u003cb\u003eTest\u003c/b\u003e를 수행하던 중 예외가 발생하여 그 해결 과정을 공유합니다. 특히, 테스트가 실패하고 있는 이슈를 디버깅하는 방법과 Gradle 관련 문제, 그리고 VSCode의 확장 기능에 대한 추가적인 설정 등을 다뤄보겠습니다. // This is a basic Flutter widget \u003cb\u003etest\u003c/b\u003e. // // To perform an...","datetime":"2023-12-18T16:13:07.000+09:00","thumbnail":"https://search2.kakaocdn.net/argon/130x130_85_c/84tJNRGjTkB","title":"[Error] Flutter Widget \u003cb\u003eTest\u003c/b\u003e: 예외 해결과정","url":"https://techtrail.tistory.com/81"},{"blogname":"시작","contents":"📌 Unit \u003cb\u003eTest\u003c/b\u003e란? Unit \u003cb\u003eTest\u003c/b\u003e(단위 테스트)는 소프트웨어 개발에서 가장 작은 단위인 \u0026#34;유닛\u0026#34;을 테스트하는 것입니다. 이 유닛은 일반적으로 함수, 메소드, 또는 클래스와 같은 작은 코드 조각을 나타냅니다. 단위 테스트는 해당 코드 조각이 의도한 대로 작동하는지 확인해 코드의 신뢰성을 높이고 버그를 미리 찾아내는 데...","datetime":"2023-12-17T19:02:59.000+09:00","thumbnail":"https://search1.kakaocdn.net/argon/130x130_85_c/4ls96x58Zo4","title":"Unit \u003cb\u003eTest\u003c/b\u003e에 대해 알아보기","url":"https://glory-dream.com/96"}],"meta":{"is_end":false,"pageable_count":792,"total_count":1980681}}
data class KakaoSearchBlogResult(
    val meta: Meta,
    val documents: List<Document>,
) {
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    data class Meta(
        val totalCount: Int,
        val pageableCount: Int,
        val isEnd: Boolean,
    )

    data class Document(
        val title: String,
        val contents: String,
        val url: String,
        val blogname: String,
        val thumbnail: String,
        val datetime: String,
    ) {
        fun toDomain() =
            Blog(
                title = title,
                contents = contents,
                url = url,
                blogName = blogname,
                datetime = datetime,
                blogVendorType = BlogVendorType.Kakao,
            )
    }

    fun getBlogs() = documents.map { it.toDomain() }
}
