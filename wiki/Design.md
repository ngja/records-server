# Design

## 필요한 정보

### Person

* 1개
  * 한글이름
  * 키
  * 혈액형
  * 성별
  * 생일
* n개
  * 이름
  * 국적
  * 학력

### Member

* 1개
  * 활동명
  * artist 합류날짜
* n개

### Artist

* 1개
  * 이름
  * 데뷔일
* n개
  * 국가별 데뷔일
  * 국가별 이름


## ERD

```mermaid
erDiagram
    PERSON {
        string name
        string custNumber
        string sector
    }
    
    MEMBER {
        long artist_id
        long person_id
    }
    
    ARTIST {
        
    }
    
```