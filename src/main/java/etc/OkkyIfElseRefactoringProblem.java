package etc;

// 아래 if else문을 리팩토링하라.
//        if (params.getUs_ticket_amt() > 0 && params.getUs_pnt_amt() > 0 && params.getUs_other_amt() > 0) { // 정액권, 포인트, 현금을 모두 사용한 경우
//            params.setType(KakaoTemplate.ALL_USE);
//        } else {
//            // 정액권을 사용한 경우
//            if (params.getUs_ticket_amt() > 0) {
//                if (params.getUs_pnt_amt() > 0) { // 포인트를 함께 사용한 경우
//                    params.setType(KakaoTemplate.TICKET_POINT_USE); // 정액권 & 포인트 결제
//                } else if (params.getUs_other_amt() > 0) { // 현금을 함꼐 사용한 경우
//                    params.setType(KakaoTemplate.TICKET_OTHER_USE); // 정액권 & 현금 결제
//                } else {
//                    params.setType(KakaoTemplate.TICKET_USE); // 정액권만 사용한 경우
//                }
//            } else if (params.getUs_pnt_amt() > 0) { // 포인트를 사용한 경우
//                if (params.getUs_other_amt() > 0) {
//                    params.setType(KakaoTemplate.POINT_OTHER_USE); // 포인트 & 현금 결제
//                } else {
//                    params.setType(KakaoTemplate.POINT_USE); // 포인트만 사용한 경우
//                }
//            } else if (params.getUs_other_amt() > 0) { // 현금을 사용한 경우
//                params.setType(KakaoTemplate.POINT_SAVE);
//            }
//            // end of first if
//        }

public class OkkyIfElseRefactoringProblem {

    public static void main(String[] args) {
        Params params = new Params();
        // NUMBER 1. params에서 getter로 값을 가져오는게 아니라 params 객체에 책임을 위임한다.
        params.setUpPaymentType();
        System.out.println(params.getType());
    }
}

class Params {

    private KakaoTemplate type;
    private long ticketAmount = 1000;
    private long pointAmount = 0;
    private long otherAmount = 3000;

    public void setUpPaymentType() {
        // NUMBER 2. 어떤 결제수단을 사용했는지 한번에 표현할 수 있는 코드를 생성
        String paymentTypeCode = makePaymentTypeCode();

        // NUMBER 3. KakaoTemplate Enum에서 코드가 일치하는 것을 찾아서 인스턴스 변수 할당
        for (KakaoTemplate paymentType : KakaoTemplate.values()) {
            if (paymentType.getCode().equals(paymentTypeCode)) {
                this.type = paymentType;
            }
        }
    }

    private String makePaymentTypeCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(ticketAmount > 0 ? 1 : 0);
        sb.append(pointAmount > 0 ? 1 : 0);
        sb.append(otherAmount > 0 ? 1 : 0);

        return sb.toString();
    }

    public KakaoTemplate getType() {
        return type;
    }
}

// 결제수단 유형이 정의된 KakaoTemplate Enum
enum KakaoTemplate {
    POINT_SAVE("001"),
    POINT_USE("010"),
    POINT_OTHER_USE("011"),
    TICKET_USE("100"),
    TICKET_OTHER_USE("101"),
    TICKET_POINT_USE("110"),
    ALL_USE("111");

    private String code;

    KakaoTemplate(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}