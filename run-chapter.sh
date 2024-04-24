#!/bin/bash

# 함수: 문자열이 숫자로만 이루어져 있는지 확인
is_numeric() {
    if [[ "$1" =~ ^[0-9]+$ ]]; then
        return 0
    else
        return 1
    fi
}

# 입력된 인자값 확인
if [ $# -ne 1 ]; then
    echo "인자로 챕터 번호를 입력해주세요."
    exit 1
fi

# 숫자로만 이루어져 있는지 확인
if ! is_numeric "$1"; then
    echo "챕터 번호는 숫자로만 이루어져야 합니다."
    exit 1
fi

# 입력된 문자열로 시작하는 폴더를 찾아서 첫 번째로 발견된 폴더의 이름을 저장
target_folder=$(find . -maxdepth 1 -type d -name "$1-*" | head -n 1)

# 폴더가 없는 경우
if [ -z "$target_folder" ]; then
    echo "해당 챕터 번호는 존재하지 않습니다."
    exit 1
fi

# 저장된 폴더로 이동
cd "$target_folder" || exit 1

# sbt 프로젝트 실행
sbt compile
sbt run