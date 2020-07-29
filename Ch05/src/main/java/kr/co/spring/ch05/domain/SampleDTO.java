package kr.co.spring.ch05.domain;

import lombok.Data;

// DTO : Data Transfer Object
// Ŭ���̾�Ʈ�� �������� �����ϴ� ������ ( �Ķ���� )���� ��� ���� ��ü

// * �⺻������ �Ķ������ �ڷ����� ������ ���ڿ�
// �������� ����ڰ� �Ķ���͸� ���ϴ� �ڷ������� ����� ���� �Ľ��� ���� �߾�� �ߴ�.
// ������ ������������ Front Controller�� �̷��� �Ľ� �۾��� ��� ���ش�.

// ������ �Ķ���� Ű���� ��ġ�Ѵٸ� �˾Ƽ� �Ľ��� ���ش�.

@Data
public class SampleDTO {
	private String name;
	private Integer age;
}
