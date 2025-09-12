Erp project

이번 erp project의 목표는 프로젝트를 끝까지 이어나갈 수 있음을 증명하는 것과 동시에 지금까지 배웠던 스프링에 대한 이해도를 점검하며, 복습하는 시간을 갖기 위함입니다.

기존에 만들 수 있었던 CRUD를 일관성있게 만드는 것을 목표로할 것이며, 새로운 기술들을 적용하는 것을 목표로 하는 프로젝트입니다. 새로운 기술은 REDIS와 Security를 목표로 합니다.
일관성있는 코드란, 기존에 get,set으로 dto를 설계하는 것을 넘어서 mapper를 사용해 builder로 원하는 데이터 모델로서 변환할 수 있도록 함으로서 일관된 객체 변환을 목표로 합니다.
또한 git을 통한 협업에서 부족함을 느꼈기에 issue 생성과 pr, 병합을 원할하게 할 수 있는 능력을 목표로 합니다.


api 명세서

1. 공통 응답 형식
   
{
    "success": true,           // boolean
    "message": "성공 메시지",   // string
    "data": {},               // 실제 데이터 (null 가능)
    "timestamp": "2024-03-21T10:00:00Z"  // ISO 8601 형식
}

2. product Api

2.1 product 생성

POST / api / post
Authorization: Bearer {token}
Content-Type: application/json

{
  "code":"pants-001",
  "category":"pants",
  "brand":"abc",
  "price":"20000",
  "description":"저렴한 가격의 훌륭한 퀄리티"
}

성공응답(201)

{
    "success": true,
    "message": "Product가 생성되었습니다.",
    "data": {
        "id": 1,
        "title": "프로젝트 기획안 작성",
        "description": "2024년 1분기 프로젝트 기획안 작성하기",
        "dueDate": "2024-04-01T23:59:59Z",
        "priority": "HIGH",
        "status": "TODO",
        "assigneeId": 1,
        "assignee": {
            "id": 1,
            "username": "johndoe",
            "name": "John Doe",
            "email": "john@example.com"
        },
        "createdAt": "2024-03-21T10:00:00Z",
        "updatedAt": "2024-03-21T10:00:00Z"
    },
    "timestamp": "2024-03-21T10:00:00Z"
}

2-
