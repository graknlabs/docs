## this filegroup exposes all .md files that are placed under the sub-directories of the root directory (where this BUILD file is located at)
## given the directory structure below, test-1.md and test-2.md are INCLUDED. test-0.md is EXCLUDED.
## root_directory:
##      test-0.md
##      sub-directory:
##          test-1.md
##          sub-sub-dir:
##              test-2.md

filegroup(
    name = "content",
<<<<<<< HEAD
    srcs = glob(
        ["*/**/*.md"],
        exclude=[
            "bazel-bin/**/*.md",
            "bazel-out/**/*.md",
            "bazel-docs/**/*.md",
            ".runfiles/**/*.md"
        ]
    ),
=======
    srcs = glob(["*/**/*.md"]),
>>>>>>> development
    visibility = ["//visibility:public"]
)