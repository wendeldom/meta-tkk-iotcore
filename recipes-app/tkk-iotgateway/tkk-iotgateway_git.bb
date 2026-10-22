SUMMARY = "TKK IoT Gateway"
LICENSE = "AGPL-3.0-only & LGPL-3.0-only & MIT & BSL-1.0"
LIC_FILES_CHKSUM = "\
file://LICENSE;md5=4ae09d45eac4aa08d013b5f2e01c67f6 \
file://include/third_party/snap7micro/lgpl-3.0.txt;md5=38138baa100d7259934590850bc0406e \
file://include/third_party/nlohmann/LICENSE.MIT;md5=e046aa7fd39db177f5ca0cefe06ddbdc \
file://include/third_party/utfcpp/LICENSE;md5=e4224ccaecb14d942c71d31bef20d78c \
"

SRC_URI = "git://...;protocol=ssh;branch=main"
SRCREV = "..."
S = "${WORKDIR}/git"

DEPENDS = "nlohmann-json mosquitto"
inherit cmake
EXTRA_OECMAKE = "-DBUILD_TESTING=OFF -DCMAKE_BUILD_TYPE=Release"